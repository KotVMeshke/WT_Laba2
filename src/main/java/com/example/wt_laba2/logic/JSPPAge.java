package com.example.wt_laba2.logic;

import com.example.wt_laba2.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public interface JSPPAge {
    public String execute(HttpServletRequest request) throws CommandException;
}
