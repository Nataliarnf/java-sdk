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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * RuntimeResponseGeneric.
 *
 * <p>Classes which extend this class: - RuntimeResponseGenericRuntimeResponseTypeText -
 * RuntimeResponseGenericRuntimeResponseTypePause - RuntimeResponseGenericRuntimeResponseTypeImage -
 * RuntimeResponseGenericRuntimeResponseTypeOption -
 * RuntimeResponseGenericRuntimeResponseTypeConnectToAgent -
 * RuntimeResponseGenericRuntimeResponseTypeSuggestion -
 * RuntimeResponseGenericRuntimeResponseTypeSearch
 */
public class RuntimeResponseGeneric extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "response_type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put(
        "connect_to_agent", RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.class);
    discriminatorMapping.put("image", RuntimeResponseGenericRuntimeResponseTypeImage.class);
    discriminatorMapping.put("option", RuntimeResponseGenericRuntimeResponseTypeOption.class);
    discriminatorMapping.put(
        "suggestion", RuntimeResponseGenericRuntimeResponseTypeSuggestion.class);
    discriminatorMapping.put("pause", RuntimeResponseGenericRuntimeResponseTypePause.class);
    discriminatorMapping.put("search", RuntimeResponseGenericRuntimeResponseTypeSearch.class);
    discriminatorMapping.put("text", RuntimeResponseGenericRuntimeResponseTypeText.class);
  }

  /**
   * The type of response returned by the dialog node. The specified response type must be supported
   * by the client application or channel.
   */
  public interface ResponseType {
    /** text. */
    String TEXT = "text";
  }

  /** The preferred type of control to display. */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  @SerializedName("response_type")
  protected String responseType;

  protected String text;
  protected Long time;
  protected Boolean typing;
  protected String source;
  protected String title;
  protected String description;
  protected String preference;
  protected List<DialogNodeOutputOptionsElement> options;

  @SerializedName("message_to_human_agent")
  protected String messageToHumanAgent;

  @SerializedName("agent_available")
  protected AgentAvailabilityMessage agentAvailable;

  @SerializedName("agent_unavailable")
  protected AgentAvailabilityMessage agentUnavailable;

  @SerializedName("transfer_info")
  protected DialogNodeOutputConnectToAgentTransferInfo transferInfo;

  protected String topic;
  protected List<DialogSuggestion> suggestions;
  protected String header;

  @SerializedName("primary_results")
  protected List<SearchResult> primaryResults;

  @SerializedName("additional_results")
  protected List<SearchResult> additionalResults;

  protected RuntimeResponseGeneric() {}

  /**
   * Gets the responseType.
   *
   * <p>The type of response returned by the dialog node. The specified response type must be
   * supported by the client application or channel.
   *
   * @return the responseType
   */
  public String responseType() {
    return responseType;
  }

  /**
   * Gets the text.
   *
   * <p>The text of the response.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the time.
   *
   * <p>How long to pause, in milliseconds.
   *
   * @return the time
   */
  public Long time() {
    return time;
  }

  /**
   * Gets the typing.
   *
   * <p>Whether to send a "user is typing" event during the pause.
   *
   * @return the typing
   */
  public Boolean typing() {
    return typing;
  }

  /**
   * Gets the source.
   *
   * <p>The URL of the image.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the title.
   *
   * <p>The title to show before the response.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * <p>The description to show with the the response.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the preference.
   *
   * <p>The preferred type of control to display.
   *
   * @return the preference
   */
  public String preference() {
    return preference;
  }

  /**
   * Gets the options.
   *
   * <p>An array of objects describing the options from which the user can choose.
   *
   * @return the options
   */
  public List<DialogNodeOutputOptionsElement> options() {
    return options;
  }

  /**
   * Gets the messageToHumanAgent.
   *
   * <p>A message to be sent to the human agent who will be taking over the conversation.
   *
   * @return the messageToHumanAgent
   */
  public String messageToHumanAgent() {
    return messageToHumanAgent;
  }

  /**
   * Gets the agentAvailable.
   *
   * <p>An optional message to be displayed to the user to indicate that the conversation will be
   * transferred to the next available agent.
   *
   * @return the agentAvailable
   */
  public AgentAvailabilityMessage agentAvailable() {
    return agentAvailable;
  }

  /**
   * Gets the agentUnavailable.
   *
   * <p>An optional message to be displayed to the user to indicate that no online agent is
   * available to take over the conversation.
   *
   * @return the agentUnavailable
   */
  public AgentAvailabilityMessage agentUnavailable() {
    return agentUnavailable;
  }

  /**
   * Gets the transferInfo.
   *
   * <p>Routing or other contextual information to be used by target service desk systems.
   *
   * @return the transferInfo
   */
  public DialogNodeOutputConnectToAgentTransferInfo transferInfo() {
    return transferInfo;
  }

  /**
   * Gets the topic.
   *
   * <p>A label identifying the topic of the conversation, derived from the **title** property of
   * the relevant node or the **topic** property of the dialog node response.
   *
   * @return the topic
   */
  public String topic() {
    return topic;
  }

  /**
   * Gets the suggestions.
   *
   * <p>An array of objects describing the possible matching dialog nodes from which the user can
   * choose.
   *
   * @return the suggestions
   */
  public List<DialogSuggestion> suggestions() {
    return suggestions;
  }

  /**
   * Gets the header.
   *
   * <p>The title or introductory text to show before the response. This text is defined in the
   * search skill configuration.
   *
   * @return the header
   */
  public String header() {
    return header;
  }

  /**
   * Gets the primaryResults.
   *
   * <p>An array of objects that contains the search results to be displayed in the initial response
   * to the user.
   *
   * @return the primaryResults
   */
  public List<SearchResult> primaryResults() {
    return primaryResults;
  }

  /**
   * Gets the additionalResults.
   *
   * <p>An array of objects that contains additional search results that can be displayed to the
   * user upon request.
   *
   * @return the additionalResults
   */
  public List<SearchResult> additionalResults() {
    return additionalResults;
  }
}
