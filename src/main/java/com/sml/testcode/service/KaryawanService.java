package com.sml.testcode.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class KaryawanService {

    public void testReactor(){
        Flux<String> flux = Flux.just("Hello", "World").map(s -> s.toUpperCase()).doOnNext(s -> System.out.println("Processing: " + s));

        flux.subscribe(s -> System.out.println("Subscriber 1: " + s));

        flux.subscribe(s -> System.out.println("Subscriber 2: " + s));
    }
}
