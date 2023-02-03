package com.busticket.Service;

import com.busticket.Entity.Route;
import com.busticket.Repository.RouteRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteServiceTest {
    @InjectMocks
    RouteService service;

    @Mock
    RouteRepository repository;
    @Test
    @Description("whenFindAll_shouldReturnListWithExpectedSize")
    void getRoute() {
        List<Route> list = new ArrayList<>();
        list.add(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        list.add(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        list.add(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        list.add(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        when(repository.findAll()).thenReturn(list);
        List<Route> result = service.getAll();
        assertEquals(4, result.size());
    }
    @Test
    @Description("whenFindById_shouldntReturnStartAmountOfAvailableTicket")
    void ticketPurchase() {
        List<Route> list = new ArrayList<>();
        list.add(new Route("Откуда-то","Куда-то","Когда-то", 1000, 10));
        when(repository.findById("1")).thenReturn(Optional.ofNullable(list.get(0)));
        assertNotEquals(10, service.ticketPurchase("1").getAvailableTicket());
    }
}