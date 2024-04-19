package ru.chernovskaya.handicapcalc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseHandicapInputDto {
  @JsonProperty("handicap_index")
  @NotNull(message = "{validation.handicap-index.not-null}")
  @Min(value = -10, message = "{validation.handicap-index.min}")
  @Max(value = 54, message = "{validation.handicap-index.max}")
  Double handicapIndex;

  @JsonProperty("slope_rating")
  @NotNull(message = "{validation.slope-rating.not-null}")
  @Min(value = 55, message = "{validation.slope-rating.min}")
  @Max(value = 155, message = "{validation.slope-rating.max}")
  Double slopeRating;

  @JsonProperty("course_rating")
  @NotNull(message = "{validation.course-rating.not-null}")
  @Min(value = 21, message = "{validation.course-rating.min}")
  @Max(value = 49, message = "{validation.course-rating.max}")
  Double courseRating;

  @NotNull(message = "{validation.par.not-null}")
  @Min(value = 27, message = "{validation.par.min}")
  @Max(value = 49, message = "{validation.par.max}")
  Integer par;
}
