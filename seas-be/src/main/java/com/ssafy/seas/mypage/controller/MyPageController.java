package com.ssafy.seas.mypage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.seas.common.constants.SuccessCode;
import com.ssafy.seas.common.dto.ApiResponse;
import com.ssafy.seas.flashcard.dto.FlashcardDto;
import com.ssafy.seas.flashcard.service.FlashcardService;
import com.ssafy.seas.member.dto.MemberDto;
import com.ssafy.seas.mypage.dto.MyPageDto;
import com.ssafy.seas.mypage.service.MyPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
	private final MyPageService myPageService;
	private final FlashcardService flashcardService;

	@GetMapping("/my-info")
	public ApiResponse<MemberDto.MyInfoResponse> getMyInfo() {

		return ApiResponse.success(SuccessCode.GET_SUCCESS, myPageService.getMyInfo());
	}

	// 방사형 그래프
	@GetMapping("/quiz-rate")
	public ApiResponse<List<MyPageDto.QuizRate>> getQuizRate() {

		return ApiResponse.success(SuccessCode.GET_SUCCESS, myPageService.getQuizRate());
	}


	// 플래시카드 즐겨찾기 목록
	@GetMapping("/flashcard/favorite")
	public ApiResponse<List<Integer>> getFavoriteFlashcardIds() {

		return ApiResponse.success(SuccessCode.GET_SUCCESS, flashcardService.getFavoriteFlashcardIds());

	// 성적 추이 그래프
	@GetMapping("/graph")
	public ApiResponse<List<MyPageDto.PerformanceGraph>> getGraph() {
		
		return ApiResponse.success(SuccessCode.GET_SUCCESS, myPageService.getQuizPerformanceGraph());
	}
}
