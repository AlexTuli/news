package com.epam.alex.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Calendar;


/**
 * Created on 1/20/2016.
 *
 * @author Bocharnikov Alexander
 */
@Data
@NoArgsConstructor
public class News {

    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String brief;
    @NotNull
    private String content;
    @NotNull
    private Calendar dateOfCreation;
//    %tm/%td/%tY

    public String getDate() {
        return String.format("%tm - %tB - %tY", dateOfCreation, dateOfCreation, dateOfCreation);
    }

    public String getDay() {
        return String.format("%td", dateOfCreation);
    }

    public String getMonth() {
        return String.format("%tm", dateOfCreation);
    }

    public String getYear() {
        return String.format("%tY", dateOfCreation);
    }

}
