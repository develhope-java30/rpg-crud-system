package com.example.rpg_crud_system;

import com.example.rpg_crud_system.controller.CharacterStatsController;
import com.example.rpg_crud_system.entity.CharacterStats;
import com.example.rpg_crud_system.service.CharacterStatsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestCharacterStats {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @MockitoBean
    private CharacterStatsService characterStatsService;
    @Autowired
    private CharacterStatsController characterStatsController;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    private CharacterStats characterStats;

    @BeforeEach
    public void setup() {
        characterStats = new CharacterStats();

        characterStats.setId(1L);
        characterStats.setCharisma(50);
        characterStats.setConstitution(50);
        characterStats.setDexterity(50);
        characterStats.setIntelligence(50);
        characterStats.setStrength(50);
        characterStats.setConstitution(50);
        characterStats.setUpdated_at(LocalDate.now());
        characterStats.setWisdom(50);


    }

    @Test
    public void testCreateCharacterStat() throws Exception {
        when(characterStatsService.addCharacterStats(any(CharacterStats.class))).thenReturn(characterStats);
        mockMvc.perform(post("/character_stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(characterStats)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.constitution").value(characterStats.getConstitution()))
                .andExpect(jsonPath("$.charisma").value(characterStats.getCharisma()))
                .andExpect(jsonPath("$.dexterity").value(characterStats.getDexterity()))
                .andExpect(jsonPath("$.strength").value(characterStats.getStrength()))
                .andExpect(jsonPath("$.dexterity").value(characterStats.getDexterity()))
                .andExpect(jsonPath("$.intelligence").value(characterStats.getIntelligence()))
                .andExpect(jsonPath("$.wisdom").value(characterStats.getWisdom()));

    }
}




