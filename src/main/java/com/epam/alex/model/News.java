package com.epam.alex.model;


import com.epam.alex.action.GetLocale;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Locale;


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

    public String getDate() {

        return String.format(GetLocale.getCurrentLocale(), "%tm - %tB - %tY", dateOfCreation, dateOfCreation, dateOfCreation);
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
