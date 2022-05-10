package com.teste.uol;

import com.teste.uol.controller.IncidenteController;
import com.teste.uol.dto.IncidenteDto;
import junit.framework.TestCase;

import java.util.List;

class InciUolApplicationTests extends TestCase {

	public void testeFuncional(){
		IncidenteController incidenteController = new IncidenteController();
		List<IncidenteDto> incidentesDto = (List<IncidenteDto>) incidenteController.listar2();
		assertEquals(true,incidentesDto != null);
		assertEquals(false,incidentesDto.isEmpty());
		assertEquals(true,incidentesDto.size() == 11);
	}
}
