package com.example.wt_laba2.logic;

import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ICommand {
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException;
}
