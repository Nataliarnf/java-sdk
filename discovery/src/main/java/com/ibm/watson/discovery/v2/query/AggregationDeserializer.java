/*
 * (C) Copyright IBM Corp. 2019, 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.discovery.v2.query;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.discovery.query.AggregationType;
import com.ibm.watson.discovery.v2.model.QueryAggregation;
import com.ibm.watson.discovery.v2.model.QueryCalculationAggregation;
import com.ibm.watson.discovery.v2.model.QueryFilterAggregation;
import com.ibm.watson.discovery.v2.model.QueryHistogramAggregation;
import com.ibm.watson.discovery.v2.model.QueryNestedAggregation;
import com.ibm.watson.discovery.v2.model.QueryTermAggregation;
import com.ibm.watson.discovery.v2.model.QueryTimesliceAggregation;
import com.ibm.watson.discovery.v2.model.QueryTopHitsAggregation;
import java.lang.reflect.Type;

/**
 * Deserializer to transform JSON into a {@link QueryAggregation}.
 *
 * @deprecated This class has been replaced by logic inside of the QueryAggregation class.
 */
public class AggregationDeserializer implements JsonDeserializer<QueryAggregation> {

  private static final String TYPE = "type";

  /**
   * Deserializes JSON and converts it to the appropriate {@link QueryAggregation} subclass.
   *
   * @param json the JSON data being deserialized
   * @param typeOfT the type to deserialize to, which should be {@link QueryAggregation}
   * @param context additional information about the deserialization state
   * @return the appropriate {@link QueryAggregation} subclass
   * @throws JsonParseException signals that there has been an issue parsing the JSON
   */
  @Override
  public QueryAggregation deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    // get aggregation type from response
    JsonObject jsonObject = json.getAsJsonObject();
    String aggregationType = "";
    for (String key : jsonObject.keySet()) {
      if (key.equals(TYPE)) {
        aggregationType = jsonObject.get(key).getAsString();
      }
    }

    QueryAggregation aggregation;
    if (aggregationType.equals(AggregationType.HISTOGRAM.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryHistogramAggregation.class);
    } else if (aggregationType.equals(AggregationType.MAX.getName())
        || aggregationType.equals(AggregationType.MIN.getName())
        || aggregationType.equals(AggregationType.AVERAGE.getName())
        || aggregationType.equals(AggregationType.SUM.getName())
        || aggregationType.equals(AggregationType.UNIQUE_COUNT.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryCalculationAggregation.class);
    } else if (aggregationType.equals(AggregationType.TERM.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryTermAggregation.class);
    } else if (aggregationType.equals(AggregationType.FILTER.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryFilterAggregation.class);
    } else if (aggregationType.equals(AggregationType.NESTED.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryNestedAggregation.class);
    } else if (aggregationType.equals(AggregationType.TIMESLICE.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryTimesliceAggregation.class);
    } else if (aggregationType.equals(AggregationType.TOP_HITS.getName())) {
      aggregation = GsonSingleton.getGson().fromJson(json, QueryTopHitsAggregation.class);
    } else {
      aggregation = GsonSingleton.getGson().fromJson(json, GenericQueryAggregation.class);
    }

    return aggregation;
  }
}
