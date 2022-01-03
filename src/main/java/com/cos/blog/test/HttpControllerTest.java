package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)
//@Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

		private static final String TAG = "HttpControllerTest : ";
		
		//application.yml 소스 수정/ localhost:8000/blog/http/lombok
		@GetMapping("/http/lombok")
		public String lombokTest()	{
//			Member m = new Member("dongbok", "pw_test", "email@test.com");
			Member m = Member.builder().username("nm_test").password("pw_test").email("email@test.com").build(); // Builder Pattern: 생성자의 순서 상관없음
			System.out.println(TAG+"getter: "+m.getUsername());
			m.setId(5000);
			m.setUsername("DB");
			System.out.println(TAG+"setter: "+m.getUsername());
			return "lombok test 완료";
		}
		
		//인터넷 브라우저 요청은 무조건 get만 가능하다.
		//쿼리 스트링 방식으로만 get 가능하다.
		//raw data -> text/plain, application/json  -> key값은 항상 "String"
		//@RequestParam이 맵핑하여 오브젝트에 넣어줌
		//id=1&username=ssar&password=1234&email=ssar@nate.com 변환 또한 스프링이 알아서 해준다.
		//http://localhost:8080/http/get(select)
		@GetMapping("/http/get")
//		public String getTest(@RequestParam int id, @RequestParam String username) {
		public String getTest(Member m) { 
			return "get 요청: "+m.getId() + ", " +  m.getUsername() +", " + m.getPassword() + ", " + m.getEmail();
		}
		
		//http://localhost:8080/http/post(insert)
		@PostMapping("/http/post")
//		public String postTest(Member m) {
//		public String postTest(@RequestBody String text) {
		public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트) text인 json형태를 오브젝트에 pasing 해줌
			return "post 요청: "+m.getId() + ", " +  m.getUsername() +", " + m.getPassword() + ", " + m.getEmail();
		}
		
		//http://localhost:8080/http/put(update)
		@PutMapping("/http/put")
		public String putTest(@RequestBody Member m) {
			return "put 요청: "+m.getId() + ", " +  m.getUsername() +", " + m.getPassword() + ", " + m.getEmail();
		}
		
		//http://localhost:8080/http/delete(delete)
		@DeleteMapping("/http/delete")
		public String deleteTest(@RequestBody Member m) {
			return "delete 요청"+m.getId() + ", " +  m.getUsername() +", " + m.getPassword() + ", " + m.getEmail();
		}
}
