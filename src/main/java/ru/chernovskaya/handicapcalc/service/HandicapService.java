package ru.chernovskaya.handicapcalc.service;

public interface HandicapService {
  double countCourseHandicap18holeWithCourseRating(
      double handicapIndex, double slopeRating, double courseRating, int par);

  double countCourseHandicap18hole(
      double handicapIndex, double slopeRating, double courseRating, int par);

  double countCourseHandicap9hole(
      double handicapIndex, double slopeRating, double courseRating, int par);
}
