package com.personal.app.handler;

import com.personal.app.models.entities.Income;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

public class IncomeHandlerRequestTest {

    @Test
    void tetBuildEntityFromRequest() {
        HttpServletRequest mockReq = mock(HttpServletRequest.class);

        when(mockReq.getParameter("amount")).thenReturn("75.5");
        when(mockReq.getParameter("description")).thenReturn("Questa e la paga");
        when(mockReq.getParameter("date")).thenReturn("2025-10-01");

        IncomeRequestHandler handler = new IncomeRequestHandler();
        Income i = handler.buildEntity(mockReq);

        // verify
        assertNotNull(i);
        assertEquals(75.5, i.getAmount());
        assertEquals("Questa e la paga", i.getDescription());
        assertEquals(LocalDate.of(2025,10,01),i.getDate());
    }

}
