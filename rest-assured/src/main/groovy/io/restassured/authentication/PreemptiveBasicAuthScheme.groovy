/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package io.restassured.authentication

import io.restassured.internal.http.HTTPBuilder

/**
 * Used for basic and digest authentication
 */
class PreemptiveBasicAuthScheme implements AuthenticationScheme {
  private static final String AUTH_ENCODING = 'iso-8859-1'

  def String userName
  def String password

  @Override void authenticate(HTTPBuilder httpBuilder) {
      httpBuilder.headers[ 'Authorization' ] =  generateAuthToken()
  }

  public String generateAuthToken() {
    ("Basic " + "$userName:$password".getBytes(AUTH_ENCODING).encodeBase64()).toString()
  }
}
