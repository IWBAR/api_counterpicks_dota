package com.iwbar.popa.service;

import com.iwbar.popa.dto.OpenDotaMatchUpDto;

import java.util.List;

public interface HeroService {
    public List<OpenDotaMatchUpDto> getCounterPicks(int heroId);
    public List<OpenDotaMatchUpDto> getHeroMatchups(int heroId);
}
