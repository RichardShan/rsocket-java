/*
 * Copyright 2015-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.rsocket.loadbalance;

import io.rsocket.RSocket;
import reactor.core.publisher.Mono;

public class LoadbalanceRSocketSource {

  final String serverKey;
  final Mono<RSocket> source;

  private LoadbalanceRSocketSource(String serverKey, Mono<RSocket> source) {
    this.serverKey = serverKey;
    this.source = source;
  }

  public Mono<RSocket> source() {
    return source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LoadbalanceRSocketSource that = (LoadbalanceRSocketSource) o;

    return serverKey.equals(that.serverKey);
  }

  @Override
  public int hashCode() {
    return serverKey.hashCode();
  }

  public static LoadbalanceRSocketSource from(String serverKey, Mono<RSocket> source) {
    return new LoadbalanceRSocketSource(serverKey, source);
  }
}
