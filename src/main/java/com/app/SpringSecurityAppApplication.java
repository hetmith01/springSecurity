package com.app;

import com.app.persistence.entity.PermisionEntity;
import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;


@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return  args -> {

			PermisionEntity createPermision = PermisionEntity.builder()
					.name("CREATE")
					.build();

			PermisionEntity readPermision = PermisionEntity.builder()
					.name("READ")
					.build();
			PermisionEntity updatePermision = PermisionEntity.builder()
					.name("UPDATE")
					.build();
			PermisionEntity deletePermision = PermisionEntity.builder()
					.name("DELETE")
					.build();
			PermisionEntity refactorPermision = PermisionEntity.builder()
					.name("REFACTOR")
					.build();

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permisionList(Set.of(createPermision, readPermision, updatePermision, deletePermision))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permisionList(Set.of(createPermision, readPermision))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permisionList(Set.of(readPermision))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permisionList(Set.of(createPermision, readPermision, updatePermision, deletePermision, refactorPermision))
					.build();

			UserEntity userJet = UserEntity.builder()
					.username("jet")
					.password("$2a$10$W3h09fRQ6QsWfcoVlBje3eqKLsrw67enyG5WTZ1neM4XHpTBQ3Q0q")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("daniel")
					.password("$2a$10$W3h09fRQ6QsWfcoVlBje3eqKLsrw67enyG5WTZ1neM4XHpTBQ3Q0q")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.username("andrea")
					.password("$2a$10$W3h09fRQ6QsWfcoVlBje3eqKLsrw67enyG5WTZ1neM4XHpTBQ3Q0q")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAnyi = UserEntity.builder()
					.username("anyi")
					.password("$2a$10$W3h09fRQ6QsWfcoVlBje3eqKLsrw67enyG5WTZ1neM4XHpTBQ3Q0q")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userJet, userAndrea, userDaniel, userAnyi));

		};
	}
}
