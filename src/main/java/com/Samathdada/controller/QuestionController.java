package com.Samathdada.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Samathdada.models.exam.Question;
import com.Samathdada.models.exam.Quiz;
import com.Samathdada.service.QuestionService;
import com.Samathdada.service.QuizService;




@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	


	@Autowired
	private QuestionService questionService;
	

	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
			return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	//get question
	@GetMapping("{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	//get all questions of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
	Set<Question> questionsOfQuiz =  (Set<Question>) this.questionService.getQuestionsOfQuiz(quiz);
	return ResponseEntity.ok(questionsOfQuiz);
	}
		/*Quiz quiz=this.quizService.getQuiz(qid);
		java.util.Set<Question> questions=quiz.getQuestions();
		List list=(List) new ArrayList(questions);
		if(((java.util.Set<Question>) list).size()>Integer.parseInt(quiz.getNumberOfQuestions()) ){
			list=(List) ((ArrayList) list).subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle((java.util.List<?>) list);
		return ResponseEntity.ok(list);*/
		//Quiz quiz=this.quizService.getQuiz(qid);
					//Set<Question>	quizquestions=quiz.getQuestions();
	
	
	//get all questions of any quiz
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
	Set<Question> questionsOfQuiz =  (Set<Question>) this.questionService.getQuestionsOfQuiz(quiz);
	return ResponseEntity.ok(questionsOfQuiz);
		
	}
	//delete question
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQuestion(quesId);
	}
	// evaluating quiz
	@PostMapping("/evaluate-quiz")
	public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){
		System.out.println(questions);
		double marksGot=0;
		Integer correctans=0;
		Integer attempt=0;
		
		for(Question q :questions){
			//System.out.println(q.getAnswer());
			Question question=this.questionService.get(q.getQuesId());
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				correctans++;
				double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksGot+=marksSingle;
			}
			if(q.getGivenAnswer()!=null) {
				attempt++;
			}
				
			
		}
		Map<String,Object> map=Map.of("marksGot",marksGot,"correctans",correctans,"attempt",attempt);
	
				
		
		//System.out.println(questions);
		return ResponseEntity.ok(map);
	}
}
