package com.matrix.Spring;

import com.matrix.Spring.entity.AccountEntity;
import com.matrix.Spring.entity.AddressEntity;
import com.matrix.Spring.entity.StudentEntity;
import com.matrix.Spring.repository.AccountRepository;
import com.matrix.Spring.repository.AddressRepository;
import com.matrix.Spring.repository.StudentRepository;
import com.matrix.Spring.service.TransferServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class Application implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;
	private final TransferServiceImpl transferService;
	private final AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override

	public void run(String... args) throws Exception {

//		StudentEntity studentEntity = StudentEntity.builder()
//				.id(2)
//				.name("Saleh")
//				.surname("Allahverdiyev")
//				.build();
//
//		AddressEntity addressEntity = AddressEntity.builder()
//				.id(2)
//				.city("Bakı")
//				.street("Şixlinski")
//				.postNumber(999)
//				.studentEntity(studentEntity)
//				.build();
//
//		addressRepository.save(addressEntity);
//
//		addressRepository.findAll().forEach(System.out::println);
//
//		AccountEntity salehAccount = new AccountEntity(1L,"Saleh",1000.0);
//		AccountEntity islamAccount = new AccountEntity(2L, "Islam", 700.0);
//
//		accountRepository.save(salehAccount);
//		accountRepository.save(islamAccount);

//		AccountEntity salehAccount = accountRepository.findByName("Saleh");
//		AccountEntity islamAccount = accountRepository.findByName("Islam");
//
//		if(ObjectUtils.isEmpty(salehAccount)){
//			throw new RuntimeException("Not enough money in your account!");
//		}
//		if(ObjectUtils.isEmpty(islamAccount)){
//			throw new RuntimeException("Acoount not found!");
//		}
//		transferService.transfer(salehAccount,islamAccount,200.0);


//		AccountEntity salehAccount = accountRepository.findByName("Saleh");
//		log.debug("salehaccount {}",salehAccount);
//		if(salehAccount.getBalance() >1600){
//			salehAccount.setName("Saleh");
//		}


	}
}
