package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.Sample;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/samples")
public class SampleController {
	@PostMapping // @RequestMapping(method = RequestMethod.POST) + @ResponseBody
	public void save(@RequestBody Sample sample) {
		System.out.println(sample);
	}

	@GetMapping // @RequestMapping(method = RequestMethod.GET) + @ResponseBody
	public List<Sample> getAll() {
		return null;
	}

	@GetMapping(value = "/{name}")
	public Sample getById(@PathVariable("name") String name) {
		return new Sample(name, 10);
	}

	// Spring cache is function level cache
	// can be added on top of any function
	
	//Cache is useful when: 
	// • Frequently use
	// • Long time execution
	// • Fixed result.

	@Cacheable("abc")// "abc" is the map name in cache
	@GetMapping("/c1/{x}")
	public int calculate(@PathVariable("x") int x) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10 * x;
	}
	@Cacheable("abc")
	@GetMapping("/c2/{x}")
	public int calculate2(@PathVariable("x") int x) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x + 1;
	}
}
