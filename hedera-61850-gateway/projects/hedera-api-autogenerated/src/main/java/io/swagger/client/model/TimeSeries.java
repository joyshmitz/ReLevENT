/*
 * Hedera - Hub for Energy Distribution and Excess Resource Allocation
 * <h2>Intended use</h2> <p>   This api is intended to be used by Market Participants who have a contract with the Grid Operator to receive additional capacity.    Schedules can be requested to receive capacity that can be used by the Market Participant. Once schedule with the provisioned capacity   is acquired the Market Participant is expected to live within those set point boundaries. If the Market Participant comes to the conclusion   that he needs more or less capacity he can updated his requested schedule. If the schedule is no longer required it is expected that the Market Participant   removes it. </p>  <h2>Authentication</h2> <p>   The api is secured with OAuth2. Once a contract is provided to the Market Participant credentials of grant type \"client_credentials\" will be provided.    The <strong>client_id</strong> and <strong>client_secret</strong> can be used to authenticate with <a href=\"https://auth.hedera.alliander.com/\">auth.hedera.alliander.com</a>. The bearer token can then be used in the Authentication header as follows <code>Authorization: Bearer &lt;token&gt;</code>. </p>  <h2>Versioning</h2> <p>   This API implements <b>MediaType-based</b> versioning. To request a specific version use the accept header, for example:   <code>Accept: application/vnd.hedera.v1+json</code>. If no version is specified you will request the latest version automatically.    Be aware that not providing a version can cause issues when breaking changes are released in the new version and is therefore not recommended.    When using and older version of the API you will received a Sunset header giving an indication of when support for that version will be removed in the future. </p>  <h2>Non breaking changes</h2> <p>   Within the current major version it is allowed to make non breaking changes in the same major version of the api. Non breaking changed are defined as follows: </p> <ul>   <li>Adding a endpoint</li>   <li>Adding a resource</li>   <li>Adding a optional field to a existing resource</li>   <li>Adding a parameter to a endpoint</li>   <li>Adding enums to fields that have a fallback (default) value</li> </ul>  <h2>Connectivity issues</h2> <p>   When experiencing connection problems with Hedera it is expected that the Market Participant falls back to its Firm Capacity specified in the contract with the Grid Operator. Reasoning behind this is that if we can not communicate anymore we run the risk of overloading the grid capacity limits. The grid must be protected and be as stable as possible at all times and when communication is not possible every Market Participant needs to fallback to its Firm Capacity limits. </p> 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@hedera.alliander.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.Period;
import io.swagger.client.model.Point;
import io.swagger.client.model.Quantity;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * TimeSeries
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-11-15T12:54:05.868886500Z[GMT]")

public class TimeSeries {
  @SerializedName("mRID")
  private UUID mRID = null;

  @SerializedName("period")
  private Period period = null;

  @SerializedName("quantity")
  private Quantity quantity = null;

  @SerializedName("points")
  private List<Point> points = new ArrayList<Point>();

  public TimeSeries mRID(UUID mRID) {
    this.mRID = mRID;
    return this;
  }

   /**
   * Get mRID
   * @return mRID
  **/
  @Schema(required = true, description = "")
  public UUID getMRID() {
    return mRID;
  }

  public void setMRID(UUID mRID) {
    this.mRID = mRID;
  }

  public TimeSeries period(Period period) {
    this.period = period;
    return this;
  }

   /**
   * Get period
   * @return period
  **/
  @Schema(required = true, description = "")
  public Period getPeriod() {
    return period;
  }

  public void setPeriod(Period period) {
    this.period = period;
  }

  public TimeSeries quantity(Quantity quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Get quantity
   * @return quantity
  **/
  @Schema(required = true, description = "")
  public Quantity getQuantity() {
    return quantity;
  }

  public void setQuantity(Quantity quantity) {
    this.quantity = quantity;
  }

  public TimeSeries points(List<Point> points) {
    this.points = points;
    return this;
  }

  public TimeSeries addPointsItem(Point pointsItem) {
    this.points.add(pointsItem);
    return this;
  }

   /**
   * The points containing the values of the time series and the relative position of the value related to the period.
   * @return points
  **/
  @Schema(required = true, description = "The points containing the values of the time series and the relative position of the value related to the period.")
  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeSeries timeSeries = (TimeSeries) o;
    return Objects.equals(this.mRID, timeSeries.mRID) &&
        Objects.equals(this.period, timeSeries.period) &&
        Objects.equals(this.quantity, timeSeries.quantity) &&
        Objects.equals(this.points, timeSeries.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mRID, period, quantity, points);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSeries {\n");
    
    sb.append("    mRID: ").append(toIndentedString(mRID)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}