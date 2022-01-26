package com.apirest.webflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

//Programação assíncrona e não bloqueante

@RestController
public class PlaylistController {

	@Autowired
	PlaylistService service;

	@GetMapping("/playlist")
	public Flux<Playlist> getPlaylist() {
		return service.findAll();
	}

	@GetMapping("/playlist/{id}")
	public Mono<Playlist> getPlaylistById(@PathVariable String id) {
		return service.findById(id);
	}

	@PostMapping("/playlist")
	public Mono<Playlist> updatePlaylist(@RequestBody Playlist playlist) {
		return service.save(playlist);
	}

//	Não bloqueia outras chamadas, mesmo ainda processando esta
	@GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {

		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<Playlist> events = service.findAll();
		System.out.println("Passou aqui events");
		return Flux.zip(interval, events);
	}
}
