package com.iwbar.popa.controller;



import com.iwbar.popa.dto.OpenDotaMatchUpDto;
import com.iwbar.popa.serviceImpl.HeroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroController {

    @Autowired
    private HeroServiceImpl heroService;

    @PostMapping("/counters/{heroId}")
    public List<OpenDotaMatchUpDto> getCounterPicks(@PathVariable int heroId){
        return heroService.getCounterPicks(heroId);
    }
}
