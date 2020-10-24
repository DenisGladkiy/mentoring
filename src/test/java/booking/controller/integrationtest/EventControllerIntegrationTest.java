package booking.controller.integrationtest;

import booking.config.MvcWebConfig;
import booking.service.EventService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcWebConfig.class})
@WebAppConfiguration
public class EventControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private EventService eventService;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        eventService.createEvent("Concert", LocalDate.now());
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesEventController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("eventController"));
    }

    @Test
    public void givenURIWithEventnameAndDate_whenMockMVC_thenResponseOK() {
        try {
            this.mockMvc.perform(post("/events?eventname=Concert&date=2010-10-10"))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenUsersURI_whenMockMVC_thenReturnsUserJSPViewName() throws Exception {
        this.mockMvc.perform(get("/events/Concert")).andDo(print())

                .andExpect(view().name("event"));
    }
}
