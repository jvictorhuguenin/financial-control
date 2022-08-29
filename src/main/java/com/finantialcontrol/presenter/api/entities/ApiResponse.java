package com.finantialcontrol.presenter.api.entities;

import lombok.Value;

@Value
public class ApiResponse {
  Boolean success;
  String message;
}
