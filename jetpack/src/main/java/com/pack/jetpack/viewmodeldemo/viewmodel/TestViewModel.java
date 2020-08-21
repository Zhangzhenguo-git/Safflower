package com.pack.jetpack.viewmodeldemo.viewmodel;

import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    private int ticketPlus;
    private int ticketReduce;

    public int getTicketPlus() {
        return ticketPlus;
    }

    public void setTicketPlus(int ticketPlus) {
        this.ticketPlus = ticketPlus;
    }

    public int getTicketReduce() {
        return ticketReduce;
    }

    public void setTicketReduce(int ticketReduce) {
        this.ticketReduce = ticketReduce;
    }
}
