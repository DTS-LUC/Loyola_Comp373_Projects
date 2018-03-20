### COMP 373/473 - Objects/Frameworks/Patterns

COMP 373/473 - Objects/Frameworks/Patterns
# Project 2: Object Wiring Using Spring – A Facility Management System

**Objective:** In this project, we will change the object dependency and collaboration management from directly instantiating to Dependency Injection container (Spring).

Domain Modeling and implementation

Implementing Dependency Injection using Spring

You need to design and implement:

– Spring container configuration for Dependency Injection for the application that you developed in Project 1.

– Using ApplicationContext Mechanism

– Dependency relationship using XML

# Project 1: Facility Management System

**To Run:**
Import into java IDE such as Eclipse or IntelliJ and run build.

**Project Description:**

In this project, we will start providing an object domain model for Facility Management System by
addressing the design and implementation using OOP. The aim is to have a domain model that is
designed using OOP that will be used to study Object relationship and Dependency.

Based on the specification provided for a Facility Management System:

- Identify the main entitles of the problem domain.
- Identify their attributes.
- Identify their relationships.
- Identify their roles and responsibilities.
- Discover other objects that facilitate implementing responsibilities.
- Make available all client interfaces/services specified in the specification document (Facility, Facility Use, and Facility Maintenance Client Interfaces).



### Facility Management System Design

**System Name:** Facility Management System

**System Description:** Facilities are the building units (buildings and rooms inside) that a company
uses to support the activities of the business. This system will support the management of buildings,
their constant use, and maintenance support when it is needed. The following are the three main
functionalities of this system:

1. Facility and its description - this will cover the functionalities such as adding a new facility to
be managed; removing a facility from being managed; getting general information such as
the number and capacity of facilities and their current statuses.
2. Facility use – this covers the functionalities of managing the facility such as reserving a
facility; the cost of using and maintaining it; assigning and de-assigning a facility for use.
3. Facility maintenance – this functionality covers the maintenance of a facility such as
scheduling a facility for maintenance; checking maintenance status; listing maintenance
requests; calculating down time of a facility and many more functionalities.
