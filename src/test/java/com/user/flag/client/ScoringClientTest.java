package com.user.flag.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

class ScoringClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ScoringClient scoringClient;

    private MockRestServiceServer mockServer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void testGetOffensivenessScore() {
        String message = "Hello";
        Float score = 0.0f;
        String scoringServiceUrl = "http://scoring-service/score";

        mockServer.expect(requestTo(scoringServiceUrl))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().string(message))
                .andRespond(withSuccess(score.toString(), MediaType.APPLICATION_JSON));

        float result = scoringClient.getOffensivenessScore(message);
        assertEquals(score, result);
        ;
    }
}