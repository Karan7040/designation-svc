package com.colruytgroup.designation.exception;

import com.colruytgroup.designation.model.enums.ErrorMessage;

public class SurveyAlreadyFilledException extends RuntimeException {

    public SurveyAlreadyFilledException() {
        super(ErrorMessage.SURVEY_ALREADY_FILLED.getMessage());
    }
}
