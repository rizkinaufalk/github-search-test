# Github Search Technical Test

## Tech Stack
- Kotlin
- Jetpack Compose
- Coroutine
- MVVM + Clean Architecture
- Hilt
- Retrofit
- Room
- Glide

## All Features and Improvements
- Search GitHub Ssers with Delayed API Call to Prevent Multiple Call API
- View user detail
- Pull to refresh
- Pagination
- Caching with Room

##  Build & Run

### Project Build With:
- Android Studio Meerkat Feature Drop | 2024.3.2 Patch 1
- Gradle 8.11.1
- SDK 35
- JVM 17
- AGP 8.6.0
- Kotlin 1.9.22

### How To Run:

1. Clone this repo:
   ```bash
   git clone https://github.com/rizkinaufalk/github-search-test.git
   

2. Add this to local.properties with your Github Token:
   ```bash
   GITHUB_TOKEN=your_github_token

## Project Breakdown

The picture below is the process before I start to develop project. I tried to understand it with my mind and start to pour all the idea into it.

<img width="1162" height="714" alt="image" src="https://github.com/user-attachments/assets/39561fdf-176e-4037-a659-58e76be2fdbc" />


##  Challenges and Notes to this project:
- Limited time, unfortunate event always come unexpected. My notebook got BSOD all weekend and just got repaired noon on monday. It may sound like an excuse, but it is what it is. At least I did my best for this test.
- Confused to decide what's localDb used for. Is it for offline mode or limit api call. but, I don't implement perfectly in here. it got mixed up and panicking because clock is ticking
- Can't implement unit test or UI Test because it's going to be took more time to implement.
- Forget to implement chucker for inspecting HTTP request andn response, but i used to implement chucker to my project with REST-API.
- Overall it was a nice experience for me to build this project

## Why Clean Architecture and MVVM?
To build modern project I've seen a trend is using Clean Architecure, and MVVM for me the first pattern I really like to use. I know someone who use compose right now is shifting from MVVM to MVI even KMP Recommendation is Using MVI especially if you are using decompose library. But I don't want to risk this test project since I only have limited time for develop.

For me Clean Architecture is great because separation of concern for this architecture is great. It makes every layer has single responsibility, that's why the code looks maintainable and scalability is great. I know some people maybe got overwhelmed if they never use Clean Architecture because it gives more process to the flow. But if it's maintain carefully, try to not "over engineer", and start getting used to it. It's really worth it.

And the most interest thing is, if you really use unit test a lot. Maybe using TDD or try to make unit test coverage 80%-100% Clean Architecture is really powerful because the single responsibility of every layer.
