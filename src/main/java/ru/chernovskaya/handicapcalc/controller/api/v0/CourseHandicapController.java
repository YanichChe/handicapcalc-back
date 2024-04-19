package ru.chernovskaya.handicapcalc.controller.api.v0;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chernovskaya.handicapcalc.dto.CourseHandicapInputDto;
import ru.chernovskaya.handicapcalc.service.HandicapService;

import static org.springframework.http.HttpStatus.OK;
import static ru.chernovskaya.handicapcalc.util.ApiUtils.API_V0_PREFIX;
import static ru.chernovskaya.handicapcalc.util.ApiUtils.COURSE_HANDICAP;
import static ru.chernovskaya.handicapcalc.util.ApiUtils.EIGHTEEN_HOLES;
import static ru.chernovskaya.handicapcalc.util.ApiUtils.EIGHTEEN_HOLES_CR;
import static ru.chernovskaya.handicapcalc.util.ApiUtils.NINE_HOLES;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V0_PREFIX + COURSE_HANDICAP)
public class CourseHandicapController {
  private final HandicapService handicapService;

  @PostMapping(EIGHTEEN_HOLES_CR)
  @CrossOrigin
  public ResponseEntity<Double> getEighteenHolesCr(
      @Valid @RequestBody CourseHandicapInputDto courseHandicapInputDto) {
    return ResponseEntity.status(OK)
        .body(
            handicapService.countCourseHandicap18holeWithCourseRating(
                courseHandicapInputDto.getHandicapIndex(),
                courseHandicapInputDto.getSlopeRating(),
                courseHandicapInputDto.getCourseRating(),
                courseHandicapInputDto.getPar()));
  }

  @PostMapping(EIGHTEEN_HOLES)
  @CrossOrigin
  public ResponseEntity<Double> getEighteenHoles(
      @Valid @RequestBody CourseHandicapInputDto courseHandicapInputDto) {
    return ResponseEntity.status(OK)
        .body(
            handicapService.countCourseHandicap18hole(
                courseHandicapInputDto.getHandicapIndex(),
                courseHandicapInputDto.getSlopeRating(),
                courseHandicapInputDto.getCourseRating(),
                courseHandicapInputDto.getPar()));
  }

  @PostMapping(NINE_HOLES)
  @CrossOrigin
  public ResponseEntity<Double> getNineHoles(
      @Valid @RequestBody CourseHandicapInputDto courseHandicapInputDto) {
    return ResponseEntity.status(OK)
        .body(
            handicapService.countCourseHandicap9hole(
                courseHandicapInputDto.getHandicapIndex(),
                courseHandicapInputDto.getSlopeRating(),
                courseHandicapInputDto.getCourseRating(),
                courseHandicapInputDto.getPar()));
  }
}
