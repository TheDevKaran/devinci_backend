
// package com.devinvi.devinci_backend.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Service;

// import com.devinvi.devinci_backend.entity.User;
// import com.devinvi.devinci_backend.exception.RateLimitExceededException;
// import com.devinvi.devinci_backend.repository.UserRepository;

// @Service
// public class RateLimitService {

//     private static final int FREE_LIMIT = 2;

//     @Autowired
//     private UserRepository userRepository;

//     public void checkAndConsume(Authentication auth) {

//         // 🚫 NO GUEST ACCESS
//         if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
//             throw new RateLimitExceededException();
//         }

//         // ✅ LOGGED-IN USER ONLY
//         String email = auth.getName();
//         User user = userRepository
//                 .findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         if (user.getUsageCount() >= FREE_LIMIT) {
//             throw new RateLimitExceededException();
//         }

//         user.setUsageCount(user.getUsageCount() + 1);
//         userRepository.save(user);
//     }

//     public int getRemainingCount(String email) {
//         User user = userRepository.findByEmail(email).orElseThrow();
//         return Math.max(0, FREE_LIMIT - user.getUsageCount());
//     }
// }