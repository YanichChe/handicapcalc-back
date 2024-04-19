package ru.chernovskaya.handicapcalc.service.impl;

import org.springframework.stereotype.Service;
import ru.chernovskaya.handicapcalc.service.HandicapService;

@Service
public class HandicapServiceImpl implements HandicapService {

  private static final int WHSConstant = 113;

  @Override
  public double countCourseHandicap18holeWithCourseRating(
      double handicapIndex, double slopeRating, double courseRating, int par) {
    return handicapIndex * slopeRating / WHSConstant + (courseRating - par);
  }

  @Override
  public double countCourseHandicap18hole(
      double handicapIndex, double slopeRating, double courseRating, int par) {
    return handicapIndex * slopeRating / WHSConstant + 2 * (courseRating - par);
  }

  @Override
  public double countCourseHandicap9hole(
      double handicapIndex, double slopeRating, double courseRating, int par) {
    return handicapIndex / 2 * slopeRating / WHSConstant + 2 * (courseRating - par);
  }
}
