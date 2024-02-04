package com.ssafy.seas.mypage.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MyPageDto {

	@Getter
	public static class QuizRate {
		private Integer categoryId;
		private String categoryName;
		private Double rate;

		@Builder
		@QueryProjection
		public QuizRate(Integer categoryId, String categoryName, Double rate) {
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.rate = rate;
		}
	}

	@Getter
	public static class CorrectCount {
		private Integer categoryId;
		private String categoryName;
		private Integer correctCount;

		@QueryProjection
		public CorrectCount(Integer categoryId, String categoryName, Integer correctCount) {
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.correctCount = correctCount;
		}
	}

	public static class PerformanceGraph {

	}

	@Getter
	public static class ScoreHistory {

		private LocalDateTime createdAt;
		private Integer score;
		private Integer round;

		public ScoreHistory(Timestamp createdAt, Integer score, Long round) {
			this.createdAt = createdAt.toLocalDateTime();
			this.score = score;
			this.round = Math.toIntExact(round);
		}

		@Builder
		public ScoreHistory(LocalDateTime createdAt, Integer score, Integer round) {
			this.createdAt = createdAt;
			this.score = score;
			this.round = round;
		}

	}

	@Getter
	public static class ScoreHistoryDetail extends ScoreHistory {

		private Integer id;
		private Integer categoryId;
		private Integer memberId;

		public ScoreHistoryDetail(Integer id, Timestamp createdAt, Integer score, Integer categoryId, Integer memberId,
			Long round) {
			super(createdAt, score, round);
			this.id = id;
			this.categoryId = categoryId;
			this.memberId = memberId;
		}
	}

}
