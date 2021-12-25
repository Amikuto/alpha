package per.ami.alpha.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import per.ami.alpha.pojo.dto.InfoPageTestData;
import per.ami.alpha.service.ApiService;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService service;

    @Test
    void getInfoGif() throws Exception {
        when(service.getPage(anyString())).thenReturn(InfoPageTestData.infoPage());

        mockMvc.perform(get("/api/info")
                        .param("currency", "RATE1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.gif", equalTo("testurl")))
                .andExpect(jsonPath("$.type", equalTo("broke")));
    }
}