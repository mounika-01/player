package com.example.player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerControllerTests {

        @Autowired
        private MockMvc mockMvc;

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectWriter objectWriter = objectMapper.writer();

        @Test
        @Order(1)
        public void testgetPlayers() throws Exception {
                mockMvc.perform(get("/players")).andExpect(status().isOk())
                                .andExpect(jsonPath("$", Matchers.hasSize(11)))
                                .andExpect(jsonPath("$[0].playerId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[0].playerName", Matchers.equalTo("Alexander")))
                                .andExpect(jsonPath("$[0].jerseyNumber", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[0].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[1].playerId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[1].playerName", Matchers.equalTo("Benjamin")))
                                .andExpect(jsonPath("$[1].jerseyNumber", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[1].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[2].playerId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[2].playerName", Matchers.equalTo("Michael")))
                                .andExpect(jsonPath("$[2].jerseyNumber", Matchers.equalTo(18)))
                                .andExpect(jsonPath("$[2].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[3].playerId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$[3].playerName", Matchers.equalTo("William")))
                                .andExpect(jsonPath("$[3].jerseyNumber", Matchers.equalTo(45)))
                                .andExpect(jsonPath("$[3].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[4].playerId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[4].playerName", Matchers.equalTo("Joshua")))
                                .andExpect(jsonPath("$[4].jerseyNumber", Matchers.equalTo(19)))
                                .andExpect(jsonPath("$[4].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[5].playerId", Matchers.equalTo(6)))
                                .andExpect(jsonPath("$[5].playerName", Matchers.equalTo("Daniel")))
                                .andExpect(jsonPath("$[5].jerseyNumber", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$[5].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[6].playerId", Matchers.equalTo(7)))
                                .andExpect(jsonPath("$[6].playerName", Matchers.equalTo("Matthew")))
                                .andExpect(jsonPath("$[6].jerseyNumber", Matchers.equalTo(34)))
                                .andExpect(jsonPath("$[6].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[7].playerId", Matchers.equalTo(8)))
                                .andExpect(jsonPath("$[7].playerName", Matchers.equalTo("Samuel")))
                                .andExpect(jsonPath("$[7].jerseyNumber", Matchers.equalTo(17)))
                                .andExpect(jsonPath("$[7].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[8].playerId", Matchers.equalTo(9)))
                                .andExpect(jsonPath("$[8].playerName", Matchers.equalTo("John")))
                                .andExpect(jsonPath("$[8].jerseyNumber", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[8].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[9].playerId", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$[9].playerName", Matchers.equalTo("Earnest")))
                                .andExpect(jsonPath("$[9].jerseyNumber", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[9].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[10].playerId", Matchers.equalTo(11)))
                                .andExpect(jsonPath("$[10].playerName", Matchers.equalTo("Bob")))
                                .andExpect(jsonPath("$[10].jerseyNumber", Matchers.equalTo(25)))
                                .andExpect(jsonPath("$[10].role", Matchers.equalTo("Batsman")));

        }

        @Test
        @Order(2)
        public void testgetNotFound() throws Exception {
                mockMvc.perform(get("/players/32")).andExpect(status().isNotFound());
        }

        @Test
        @Order(3)
        public void testgetPlayerById() throws Exception {
                mockMvc.perform(get("/players/1")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Alexander")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("All-rounder")));

                mockMvc.perform(get("/players/2")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Benjamin")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("All-rounder")));

                mockMvc.perform(get("/players/3")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Michael")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(18)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Batsman")));

                mockMvc.perform(get("/players/4")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("William")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(45)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Batsman")));

                mockMvc.perform(get("/players/5")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Joshua")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(19)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Batsman")));

                mockMvc.perform(get("/players/6")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(6)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Daniel")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Bowler")));

                mockMvc.perform(get("/players/7")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(7)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Matthew")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(34)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Bowler")));

                mockMvc.perform(get("/players/8")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(8)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Samuel")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(17)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Batsman")));

                mockMvc.perform(get("/players/9")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(9)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("John")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Bowler")));

                mockMvc.perform(get("/players/10")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Earnest")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("All-rounder")));

                mockMvc.perform(get("/players/11")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(11)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Bob")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(25)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Batsman")));
        }

        @Test
        @Order(4)
        public void testpost() throws Exception {
                Player player = new Player(12, "Prince", 24, "Bowler");
                String content = objectWriter.writeValueAsString(player);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/players")
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(12)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Prince")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(24)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Bowler")));
        }

        @Test
        @Order(5)
        public void testafterpost() throws Exception {
                mockMvc.perform(get("/players/12")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(12)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Prince")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(24)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("Bowler")));

        }

        @Test
        @Order(6)
        public void testputNotFound() throws Exception {
                Player player = new Player(3, "Yuvi", 12, "All-rounder");
                String content = objectWriter.writeValueAsString(player);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/players/39")
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest).andExpect(status().isNotFound());

        }

        @Test
        @Order(7)
        public void testput() throws Exception {
                Player player = new Player(3, "Yuvi", 12, "All-rounder");
                String content = objectWriter.writeValueAsString(player);

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/players/3")
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                                .content(content);

                mockMvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Yuvi")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(12)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("All-rounder")));

        }

        @Test
        @Order(8)
        public void testafterput() throws Exception {

                mockMvc.perform(get("/players/3")).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                                .andExpect(jsonPath("$.playerId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$.playerName", Matchers.equalTo("Yuvi")))
                                .andExpect(jsonPath("$.jerseyNumber", Matchers.equalTo(12)))
                                .andExpect(jsonPath("$.role", Matchers.equalTo("All-rounder")));

        }

        @Test
        @Order(9)
        public void testdeleteNotFound() throws Exception {

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/players/120")
                                .contentType(MediaType.APPLICATION_JSON);
                mockMvc.perform(mockRequest).andExpect(status().isNotFound());

        }

        @Test
        @Order(10)
        public void testdelete() throws Exception {

                MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/players/12")
                                .contentType(MediaType.APPLICATION_JSON);
                mockMvc.perform(mockRequest).andExpect(status().isNoContent());
        }

        @Test
        @Order(11)
        public void testafterdelete() throws Exception {
                mockMvc.perform(get("/players")).andExpect(status().isOk())
                                .andExpect(jsonPath("$", Matchers.hasSize(11)))
                                .andExpect(jsonPath("$[0].playerId", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[0].playerName", Matchers.equalTo("Alexander")))
                                .andExpect(jsonPath("$[0].jerseyNumber", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[0].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[1].playerId", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[1].playerName", Matchers.equalTo("Benjamin")))
                                .andExpect(jsonPath("$[1].jerseyNumber", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[1].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[2].playerId", Matchers.equalTo(3)))
                                .andExpect(jsonPath("$[2].playerName", Matchers.equalTo("Yuvi")))
                                .andExpect(jsonPath("$[2].jerseyNumber", Matchers.equalTo(12)))
                                .andExpect(jsonPath("$[2].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[3].playerId", Matchers.equalTo(4)))
                                .andExpect(jsonPath("$[3].playerName", Matchers.equalTo("William")))
                                .andExpect(jsonPath("$[3].jerseyNumber", Matchers.equalTo(45)))
                                .andExpect(jsonPath("$[3].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[4].playerId", Matchers.equalTo(5)))
                                .andExpect(jsonPath("$[4].playerName", Matchers.equalTo("Joshua")))
                                .andExpect(jsonPath("$[4].jerseyNumber", Matchers.equalTo(19)))
                                .andExpect(jsonPath("$[4].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[5].playerId", Matchers.equalTo(6)))
                                .andExpect(jsonPath("$[5].playerName", Matchers.equalTo("Daniel")))
                                .andExpect(jsonPath("$[5].jerseyNumber", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$[5].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[6].playerId", Matchers.equalTo(7)))
                                .andExpect(jsonPath("$[6].playerName", Matchers.equalTo("Matthew")))
                                .andExpect(jsonPath("$[6].jerseyNumber", Matchers.equalTo(34)))
                                .andExpect(jsonPath("$[6].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[7].playerId", Matchers.equalTo(8)))
                                .andExpect(jsonPath("$[7].playerName", Matchers.equalTo("Samuel")))
                                .andExpect(jsonPath("$[7].jerseyNumber", Matchers.equalTo(17)))
                                .andExpect(jsonPath("$[7].role", Matchers.equalTo("Batsman")))

                                .andExpect(jsonPath("$[8].playerId", Matchers.equalTo(9)))
                                .andExpect(jsonPath("$[8].playerName", Matchers.equalTo("John")))
                                .andExpect(jsonPath("$[8].jerseyNumber", Matchers.equalTo(1)))
                                .andExpect(jsonPath("$[8].role", Matchers.equalTo("Bowler")))

                                .andExpect(jsonPath("$[9].playerId", Matchers.equalTo(10)))
                                .andExpect(jsonPath("$[9].playerName", Matchers.equalTo("Earnest")))
                                .andExpect(jsonPath("$[9].jerseyNumber", Matchers.equalTo(2)))
                                .andExpect(jsonPath("$[9].role", Matchers.equalTo("All-rounder")))

                                .andExpect(jsonPath("$[10].playerId", Matchers.equalTo(11)))
                                .andExpect(jsonPath("$[10].playerName", Matchers.equalTo("Bob")))
                                .andExpect(jsonPath("$[10].jerseyNumber", Matchers.equalTo(25)))
                                .andExpect(jsonPath("$[10].role", Matchers.equalTo("Batsman")));

        }

}
