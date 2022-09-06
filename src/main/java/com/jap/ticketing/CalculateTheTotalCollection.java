package com.jap.ticketing;

import java.util.List;

@FunctionalInterface
public interface CalculateTheTotalCollection {
    double totalCollection(List<Ticket>list1);
}