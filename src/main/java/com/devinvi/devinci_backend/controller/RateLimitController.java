
// package com.devinvi.devinci_backend.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// import com.devinvi.devinci_backend.service.RateLimitService;

// // import com.devinvi.devinci_backend.service.RateLimitService;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/usage")
// public class RateLimitController {

//     @Autowired
//     private RateLimitService rateLimitService;

//     @GetMapping("/remaining")
//     public ResponseEntity<?> getRemaining(Authentication auth) {

//         if (auth == null || !auth.isAuthenticated()) {
//             return ResponseEntity.ok(Map.of("remaining", 0));
//         }

//         int remaining = rateLimitService.getRemainingCount(auth.getName());

//         return ResponseEntity.ok(Map.of(
//                 "remaining", remaining
//         ));
//     }
// }
