**Project Name:** Super Smart Bros.
**Team:** Zachary Fouts (Provider), Michael Chatman (User)
**Course:** CSC-340 Section 02
**Version:** 1.0.1
**Date:** 2026-02-13

---

## 1. Overview
**Vision.** This app is created for expanding the competitive Super Smash Bros. scene by providing users with the resources to improve at the game, even at a casual level. This app is meant to be for anyone looking to improve at Super Smash Bros and be more involved with its community.

**Glossary** Terms used in the project
- **Term 1:** Player: The user who is actively playing Super Smash Bros. and is looking for a resource to gain coaching
- **Term 2:** Coach - The provider who helps teach Super Smash Bros. in order to gift their skills to the future player base
- **Term 3:** Bio - a summary of the person and their experience with Super Smash Bros. to tell the user more about the coach they might be requesting services from

**Primary Users / Roles.**
- **Customer (Player)** — Ability to purchase coaching services from providers and choose between different coaching sessions.
- **Provider (Coach)** Be able to provide coaching services to players interested in improving at Super Smash Bros.

**Scope (this semester).**
- <capability 1> Browse and filter through different coaching posts
- <capability 2> purchase coaching and unlock messaging to the provider
- <capability 3> Write reviews on coaches with a 5 star system for users to use
- <capability 4> Read user reviews and provide further messages/feedback as needed

**Out of scope (deferred).**
- <deferred 1> international coaching and app usage
- <deferred 2> time scheduling within the app to speed up the process
- <deferred 3> ijmplementing different time zones

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑CUST‑001 — <Account Registration>**  
  _Story:_ As a customer, I want to sign up for/log in to an account so that I can search and pay for coaching sessions, and select the session type that best suits my needs (active session or asynchronous.)
  _Acceptance:_
  ```gherkin
  Scenario: <player creates an account>
    Upon checking (eventual) database, see that user does not have an account
    When  Proper fields are filled out in the account creation
    Then  the player's account is created and stored in the system (database).
  ```

- **US‑CUST‑002 — <Browsing>**  
  _Story:_ As a customer, I want to browse coaching sessions so that I can purchase one and plan the session through messages
  _Acceptance:_
  ```gherkin
  Scenario: <player filters through coaching posts and selects a preferrable one>
    Given a player is searching for a coaching session through the app
    When  a coaching session is filtered through and found
    Then  Player can click on the coaching post in order to purchase it, which then notifies the provider through email.
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — <Profile Creation>**  
  _Story:_ As a provider, I want to create a profile for myself so that players can pick me if I'm a good fit for the coaching they're looking for
  _Acceptance:_
  ```gherkin
  Scenario: <provider creates profile that gets posted to app>
    Given Profile/Bio is not created
    When  Profile and Bio are created with proper filter keywords
    Then  the Profile/Bio is visible within the app and can be managed and purchased
  ```

- **US‑PROV‑002 — <Review Viewing>>**  
  _Story:_ As a provider, I want to read and respond to reviews so I can refute any potential challenges to the validity of my coaching.
  _Acceptance:_
  ```gherkin
  Scenario: <reviews can be responded to and viewed publicly>
    Given a user posts a review on a coach's profile
    When  the review is posted
    Then  I can see and/or respond to the review to provide more insight on said review
  ```

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** 90% of discovery responses in less than 1.5 seconds; 85% of page details in under 1 second on a typical load
- **Availability/Reliability:** 99% uptime (maintinence excluded); basic reloads for load failure
- **Security/Privacy:** fully encrypted and stored passwords; possible 2FA usage
- **Usability:** New users complete first coaching purchase in less than 5 minutes in hallway tests

---

## 4. Assumptions, Constraints, and Policies
- Modern Browsers; stable connectivity and adaptive usage
- Course timeline & campus infrastructure constraints apply.
- Policies: reviews allowed within 1 week of end of coaching session; content guidelines (highlight respectfulness and being constructive instead of mean); cancellation policies if terms violated; capacity rule in case of overbooking

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
