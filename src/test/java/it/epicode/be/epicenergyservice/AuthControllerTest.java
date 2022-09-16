package it.epicode.be.epicenergyservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

	//StatoFattura statoFattura;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithAnonymousUser
	public void loginNoBody() throws Exception {
		this.mockMvc.perform(post("/auth/login")).andExpect(status().isBadRequest());
	}

	@Test
	@WithAnonymousUser
	public void getAllClienti() throws Exception {

		this.mockMvc.perform(get("/api/findallclienti")).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "user", password = "user", roles = "USER")
	public void listaComuniWhenUtenteMockIsAuthenticated() throws Exception {
		this.mockMvc.perform(get("/api/findallcomuni")).andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void listaClientiWhenUtenteMockIsAuthenticated() throws Exception {
		this.mockMvc.perform(get("/api/findallclienti")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "user", password = "user", roles = "USER")
	public void saveFatturaWhenUtenteMockIsAuthenticatedByUser() throws Exception {
		this.mockMvc.perform(delete("/api/deletecomune/1")).andExpect(status().isForbidden());
	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void deleteStatoWhenUtenteMockIsAuthenticatedByUser() throws Exception {
		this.mockMvc.perform(delete("/api/deletestato/3")).andExpect(status().isOk());
	}
		
}