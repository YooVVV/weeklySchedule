# weeklySchedule
## author: YooVVV
## start date: 2022.03.09

### Introduction:

This app is about schedules. The app will have the function of creating new schedule, displaying
schedule, editing schedule and deleting schedule. All the functions above will be implemented in the
 *milestone 2*.

### Milestone 1:

**Expected due date**: 2022.3.20

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
  
    - [ ] the start time of a day will be 6 am and the end time will be 9 pm
  
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
 of week (string).

**Wireframes**

- Starting page
![Starting Page](https://drive.google.com/uc?export=view&id=1vRoRjboV0FGC9QH4_fvDbgAA8DMGm4fi)