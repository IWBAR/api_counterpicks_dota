package com.iwbar.popa.serviceImpl;

import com.iwbar.popa.dto.OpenDotaMatchUpDto;
import com.iwbar.popa.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

    @Autowired
    private final WebClient openDotaWebClient;

    @Override
    public List<OpenDotaMatchUpDto> getCounterPicks(int heroId){
    List<OpenDotaMatchUpDto> matchUps = getHeroMatchups(heroId);
    //todo кароче получить матчапы, высчитать винрейт каждого матчапа, отсеять те, где винрейт <50%, потом отсортировать их
    // возвращать 5 самых прикольных, но при этом чтобы игр было хотя бы больше 100
     val counterpicks = matchUps.stream()
             .filter(m ->  m.getWinRate()>50)
             .sorted(Comparator.comparingDouble(OpenDotaMatchUpDto::getWinRate).reversed())
             .sorted(Comparator.comparingInt(OpenDotaMatchUpDto::getGamesPlayed).reversed())
             .limit(5)
             .toList();
        return counterpicks;
    }


    @Override
    public List<OpenDotaMatchUpDto> getHeroMatchups(int heroId) {
        return openDotaWebClient.get()
                .uri("/heroes/{heroId}/matchups", heroId)
                .retrieve()
                .bodyToFlux(OpenDotaMatchUpDto.class)
                .collectList()
                .block(Duration.ofSeconds(30));
    }
}
