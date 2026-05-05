# MVC Use-Case Implementation Map

This README maps the project's main use cases to the MVC implementation. The app is an MVC application for Super Smart Bros. where customers browse sessions, book coaching, and review providers, while providers manage profiles and coaching listings.

## Project MVC Structure

- **Models**: `backend-api/src/main/java/com/example/demo/model`
  - Main entities: `Customer`, `Provider`, `Listing`, `Booking`, `Review`, `Games`
- **Persistence layer**: `backend-api/src/main/java/com/example/demo/repository`
  - Spring Data repositories such as `CustomerRepository`, `ProviderRepository`, `ListingRepository`, `BookingRepository`, and `ReviewRepository`
- **Business logic layer**: `backend-api/src/main/java/com/example/demo/service`
  - Services such as `CustomerService`, `ProviderService`, `ListingService`, `BookingService`, and `ReviewService`
- **Controllers**: `backend-api/src/main/java/com/example/demo/controller` and `backend-api/src/main/java/com/example/demo/ui`
  - Web page controllers return FreeMarker templates.
  - REST controllers expose JSON-style API endpoints.
- **Views**: `backend-api/src/main/resources/templates`
  - FreeMarker templates such as `services.ftlh`, `login.ftlh`, `signup.ftlh`, `payment.ftlh`, `profile.ftlh`, and provider/listing/review pages.

## Use Cases Mapped to MVC Implementation

| Use Case | Route or Entry Point | Controller | Model and Service Implementation | View |
| --- | --- | --- | --- | --- |
| Redirect users to the customer services page | `GET /` | `HomeController.home()` | No model logic; redirects to the main listing browse flow. | Redirects to `services.ftlh` through `/services`. |
| Customer login | `GET /login`, Spring Security form login | `AuthController.login()` and `SecurityConfig.formLogin()` | `CustomUserDetailsService` loads customer/provider credentials; `SecurityConfig` uses `PasswordEncoder` and redirects providers to their dashboard or customers to `/services`. | `login.ftlh` |
| Customer or provider signup from the shared signup page | `GET /signup`, `POST /signup` | `AuthController.signupForm()`, `AuthController.signup()` | Creates either a `Customer` through `CustomerService.saveCustomer()` or a `Provider` through `ProviderService.createProvider()` based on `accountType`; passwords are encoded before saving. | `signup.ftlh`; redirects to `/login` after success. |
| Browse coaching sessions as a customer | `GET /services` | `ListingViewController.showServices()` | `ListingService.getAllListings()` loads `Listing` records; `ReviewRepository.findForListing()` attaches visible reviews; `BookingRepository.findAll()` marks listings as booked for the logged-in customer. | `services.ftlh` renders session cards, prices, reviews, booking links, and review forms for booked sessions. |
| Book a coaching session with payment form | `GET /book/{listingId}`, `POST /book/confirm/{listingId}` | `BookingController.showPayment()`, `BookingController.confirmBooking()` | Finds the logged-in `Customer` by email, loads the selected `Listing`, creates a `Booking`, and saves it through `BookingService.save()`. | `payment.ftlh`; redirects to `/services` with the flash message `Payment successful! Booking created.` |
| Leave a review after booking | `POST /review/{listingId}` | `ReviewController.submitReview()` | Uses `BookingRepository` to verify the customer has booked the listing; attaches `Customer` and `Listing` to `Review`; persists through `ReviewService.save()`. | Review form is embedded in `services.ftlh`; failed review attempts redirect to `/services` with `You must book before reviewing.` |
| Edit customer profile | `GET /customers/profile`, `POST /customers/profile` | `CustomerViewController.showProfile()`, `CustomerViewController.updateProfile()` | Looks up the logged-in `Customer` by principal email, updates first name, last name, email, and phone, then saves with `CustomerRepository.save()`. | `profile.ftlh`; redirects to `/services` after save. |
| Create, update, or delete customers through API | `POST /api/customers`, `PUT /api/customers/{id}`, `DELETE /api/customers/{id}` | `CustomerController` | Uses `CustomerService.create()`, `CustomerService.update()`, and `CustomerService.delete()` with the `Customer` entity. | REST responses only; no FreeMarker view. |
| Provider login outside the shared Spring login form | `GET /provider/login`, `POST /provider/login` | `ProviderUiController.login()`, `ProviderUiController.loginProvider()` | `ProviderService.login()` finds the provider by email and checks the password through `PasswordEncoder.matches()`. | `provider-login.ftlh`; redirects to `/provider/dashboard/{id}` when valid. |
| Provider registration | `GET /provider/register`, `POST /provider/register` | `ProviderUiController.register()`, `ProviderUiController.createAccount()` | Creates a `Provider` with `ProviderService.createProvider()` and encoded password storage. | `provider-signup.ftlh`; redirects to `/provider/login`. |
| Provider dashboard | `GET /provider/dashboard/{id}` | `ProviderUiController.hub()` | Loads the `Provider` with `ProviderService.getProviderById()` and that provider's listings with `ListingService.getListingByCoachId()`. | `provider-page.ftlh` displays profile info and owned coaching sessions. |
| Provider profile update | `GET /provider/update/{id}`, `POST /provider/update/{id}` | `ProviderUiController.showUpdatePage()`, `ProviderUiController.updateProfile()` | `ProviderService.updateProvider()` updates email, password, name, game username, socials, and bio. | `provider-update-profile.ftlh`; redirects back to provider dashboard. |
| Provider creates a coaching listing | `GET /listings/create/{providerId}`, `POST /listings/create/{providerId}` | `ListingUiController.createForm()`, `ListingUiController.createPost()` | Creates a `Listing`, sets `coachId` to the provider id, and persists with `ListingService.createListing()`. Fields include `game`, `experience`, `mainC`, `price`, `sessionType`, and `bio`. | `coaching-Post.ftlh`; redirects to `/listings/id/{sessionId}` after creation. |
| Provider views listing details | `GET /listings/id/{id}` | `ListingUiController.getListingById()` | Loads the `Listing` and its `Provider` using `ListingService.getListingById()` and `ProviderService.getProviderById()`. | `listing-Details.ftlh` |
| Provider updates or deletes a listing | `POST /listings/update/{id}`, `GET /listings/delete/{id}` | `ListingUiController.Listing()`, `ListingUiController.deleteCharacter()` | `ListingService.updateListing()` edits listing details; `ListingService.deleteListing()` removes the listing and returns to the provider dashboard. | Update form should post to `/listings/update/{id}`; delete begins from `listing-Details.ftlh`. |
| List or create listings through API | `GET /api/listings`, `GET /api/listings/{id}`, `POST /api/listings` | `ListingController` | Uses `ListingService.getAllListings()`, `ListingService.getListingById()`, and `ListingService.createListing()`. | REST responses only; no FreeMarker view. |
| List or create providers through API | `GET /api/provider`, `GET /api/provider/{id}`, `POST /api/provider` | `ProviderController` | Uses `ProviderService.getAll()`, `ProviderService.getProviderById()`, and `ProviderService.createProvider()`. | REST responses only; no FreeMarker view. |
| View reviews for a provider listing | `GET /reviews/listing/id/{id}` | `ReviewUiController.getReviewsByPost()` | Loads reviews through `ReviewService.getByListingId()`, then loads the related `Listing` and `Provider`. | `review-List.ftlh` |
| Create reviews through the older review view flow | `GET /reviews/new`, `POST /reviews` | `ReviewViewController` | Uses `ReviewService.saveReview(customerId, listingId, review)`, which verifies the customer booked the listing before saving. | `review-form.ftlh`; redirects to `/services`. |
| Create bookings through the older booking form flow | `GET /bookings/new/{listingId}`, `POST /bookings` | `BookingViewController` | Uses `BookingService.saveBooking(customerId, listingId)`, which creates a `Booking` with status `CONFIRMED`. | `booking-form.ftlh`; redirects to `/services`. |

## Domain Rules Reflected in the Code

- A `Listing` belongs to a provider through `coachId`.
- A `Booking` connects a `Customer` to a `Listing`.
- A `Review` connects a `Customer` to a `Listing`.
- Customers can only review a listing after booking it.
- Provider and customer passwords are encoded through the configured `PasswordEncoder`.
- Supported Smash game values come from the `Games` enum and are stored on `Listing.game`.