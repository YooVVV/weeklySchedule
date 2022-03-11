# weeklySchedule
## author: YooVVV
## start date: 2022.03.09

### Introduction:

This app is about schedules. The app will have the function of creating new schedule, displaying
schedule, editing schedule and deleting schedule. All the functions above will be implemented in the
 *milestone 2*.

### Milestone 1:

**Expected due date**: 2022.03.20

**Brainstorm**: 

Functions:

- create/edit schedule:
    
    - [ ] add new event with title, description, start time, end time
    
    - [ ] conflict time is not available in *milestone 2*
    
    - [ ] can add multiple events
    
    - [ ] events can be repeated in a week at the same time
  
    - [ ] edit schedule will cover the old one
    

- delete schedule:
    
    - [ ] delete the schedule data
  
    - [ ] deleted schedule will not be recovered


- display schedule:
  
    - [ ] display 7 days of a week and start with Monday
  
    - [ ] the start time of a day will be 4 am and the end time will be 4 am
  
    - [ ] same events will be the same color
  
    - [ ] the schedule will be static and not be interactive in *milestone 2*
    
Using:

- Enter the app and seeing 2 selection on the screen: add, choose.
   
- In add page, user can add schedule.

- If a user click on add schedule, the app will redirect to a new page with an empty list.
   
- Click on a button to add event to the schedule.

- Adding new event will be on a page and after filling all information and user can click on the
 button to finish adding the new event.
  
- Added events will be in the list.

- Clicking on "SAVE" to save changes.

- In choose page, user can choose schedule to display.

- Displaying all events of a schedule.

- In the display page, user can choose to edit or delete the schedule.

- Clicking on "EDIT" will redirect to the list of the schedule.

- Clicking on "DELETE" will delete the schedule and return to the schedule list.

**Data structure**

A schedule has ID (string), list of events (arraylist).

A event has title (string), description (string), start time (date), end time (date), days
 of week (int array).

**Wireframes**

- Starting page
  
  https://drive.google.com/file/d/1vRoRjboV0FGC9QH4_fvDbgAA8DMGm4fi/view?usp=sharing

- Event List Page

  https://drive.google.com/file/d/1mVjhjaomMnaCfc6iywZu1KdwsphRFyel/view?usp=sharing

- New Event Page

  https://drive.google.com/file/d/1t7MH69yKbPq6LwBHCI2LFGmle3Rd-n1h/view?usp=sharing

- Schedule List Page

  https://drive.google.com/file/d/16P2rXG9XMqum5ahtaz3JPS0_5rwLUkP3/view?usp=sharing

- Schedule Display Page

  https://drive.google.com/file/d/1R32fb_cE0irAjTzYaLQqLWCJkkeMphOW/view?usp=sharing


### Milestone 2:

**Expected due date**: 2022.04.10

**User Stories**

1. As a user, I want to be able to access two pages from main page, so that I can add a new schedule
 or select saved schedules.
   
2. As a user, I want to access a list of events of schedule, so that I can see the events in
a schedule.
   
3. As a user, I want to have a button in events list, so that I can add a new event.

4. As a user, I want to fill all the section in New Event Page, so that I can add a new event.

5. As a user, I want to keep event description blank, so that I can add a event without description.

6. As a user, I want to access a list of saved schedules, so that I can select a schedule to 
   display.

7. As a user, I want to add an event in multiple days of a week, so that I can have the same event
 few times in a week.
   
8. As a user, I want to access event list of a schedule after saving, so that I can edit it and
 make changes.
   
9. As a user, I want to remove an event from event list, so that I can remove an unuseful event.

10. As a user, I want to remove a schedule, so that I can remove an unuseful schedule.

11. As a user, I want to see a schedule with events in different colors, so that I can read the
 schedule more clear.