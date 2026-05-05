**Project Name: Super Smart Bros.**   
**Version: 1.0.1** 
**Date: 5/3/26**  
**Purpose: Provide a service to coach YOU to get better at competitive Super Smash Bros.** 

## Actors
- Provider P:
- Player C:
- Service S: Coaching Listing

## Use Cases
#### 1. Player: US‑CUST‑001 — Register & manage profile
1. Player C1 logs in for the first time and creates a profile.
2. C1 edits their profile to add preferences.
3. C1 exists.

#### 2. 
1. Player C1 views available coaching listings. Player can see any pre-existing reviews of coaching listings. 

#### 3.
1. Player C1 purchases a coaching listing. 

#### 4.
1. Player C1 writes a review for coaching listing.

#### 6. Provider: Coach US-PROV-001 - Profile Creation
1. Coach opens the login page and signs up using the sign up page
2. Coach logs in and edits profile page to their liking

#### 7. Provider: Coach US-PROV-002 - View Reviews
1. Coach tabs into a listing they've created
2. Coach views reviews from that page

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Discover page response time < 1.5 seconds**
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "Browse" page load with 5 active providers, 10+ services
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

**Scenario P2:** Dashboard page response time < 1 second
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "dashboard" page load with 1 active provider
  2. repeat 15 times
- **Expected Outcome:** 98% of requests < 1 second 

### Security & Privacy Requirements

**Scenario S1:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:** 

**Scenario S2:** Provider Logs in
- **Setup:** Input email and password
- **Steps:**
  1. User logs in
- **Expected Outcome:** User won't be granted any access to provider services without being authenticated by the system

### Usability Requirements

**Scenario U1:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:** 

**Scenario U2:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:** 