package com.apirest.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.repository.PlaylistRepository;

import lombok.Data;
import reactor.core.publisher.Flux;

//Used only for first bank population.
//@Data
//@Component
//public class DummyData implements CommandLineRunner{
//
//	private final PlaylistRepository playlistRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		playlistRepository.deleteAll()
//			.thenMany(
//					Flux.just("API REST Spring boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
//						"Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
//					.map(name -> new Playlist(UUID.randomUUID().toString(), name))
//					.flatMap(playlistRepository::save))
//			.subscribe(System.out::println);
//					
//	}
//	
//}
