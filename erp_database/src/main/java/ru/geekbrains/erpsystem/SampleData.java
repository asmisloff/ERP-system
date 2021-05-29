//package ru.geekbrains.erpsystem;
//
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.geekbrains.erpsystem.entities.*;
//import ru.geekbrains.erpsystem.repositories.*;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class SampleData {
//
//    @Autowired private RoleRepository roleRepository;
//    @Autowired private UserRepository userRepository;
//    @Autowired private WorkcellRepository workcellRepository;
//    @Autowired private OperationRepository operationRepository;
//    @Autowired private OperationEntryRepository operationEntryRepository;
//    @Autowired private TechnologyRepository technologyRepository;
//    @Autowired private MaterialRepository materialRepository;
//    @Autowired private UnitRepository unitRepository;
//    @Autowired private UnitRelationRepository unitRelationRepository;
//    @Autowired private TicketRepository ticketRepository;
//    @Autowired private UnitEntryRepository unitEntryRepository;
//    private Logger logger = Logger.getLogger(SampleData.class);
//
//    @PostConstruct
//    public void populate() {
//
//        Role constructor = new Role();
//        constructor.setName("Конструктор");
//        Role technologist = new Role();
//        technologist.setName("technologist");
//        roleRepository.save(constructor);
//        roleRepository.save(technologist);
//
//        User vasya = new User();
//        vasya.setName("Человек-конструктор");
//        vasya.setRole(constructor);
//        User petya = new User();
//        petya.setName("Человек-технолог");
//        petya.setRole(technologist);
//        userRepository.save(vasya);
//        userRepository.save(petya);
//
//        Workcell machine1 = new Workcell();
//        machine1.setName("Сверлильный #1");
//        machine1.setDescription("Сверлильный станок");
//        Workcell machine2 = new Workcell();
//        machine2.setName("Фрезер #1");
//        machine2.setDescription("Фрезерный станок");
//        workcellRepository.save(machine1);
//
//        Operation op1 = new Operation();
//        op1.setName("Сверление");
//        Operation op2 = new Operation();
//        op2.setName("Фрезеровка");
//        Operation op3 = new Operation();
//        op3.setName("Нарезание резьбы");
//        operationRepository.saveAll(List.of(op1, op2, op3));
//
//        OperationEntry oe1 = new OperationEntry();
//        Technology technology = new Technology();
//        oe1.setOperation(op1);
//        oe1.setDuration(1f);
//        oe1.setTechnology(technology);
//        oe1.setTurn(0);
//        oe1.setParams("{Диаметр: 7.5, Глубина: 25}");
//        OperationEntry oe2 = new OperationEntry();
//        oe2.setOperation(op2);
//        oe2.setDuration(25f);
//        oe2.setTechnology(technology);
//        oe2.setTurn(0);
//        oe2.setParams("{Диаметр инструмента: 10, Глубина: 20, Глубина за проход: 2, Длина траектории: 113}");
//        OperationEntry oe3 = new OperationEntry();
//        oe3.setOperation(op3);
//        oe3.setDuration(1f);
//        oe3.setTechnology(technology);
//        oe3.setTurn(0);
//        oe3.setParams("{Номинал: M8, Глубина: 22, Внутренняя}");
//        technology.setTechnologist(petya);
//        technology.setOperationEntries(List.of(oe3, oe2));
//        technologyRepository.save(technology);
//        operationEntryRepository.saveAll(List.of(oe3, oe2, oe3));
//
//        Material material1 = new Material();
//        material1.setArt("Круг 10 Ст3");
//        material1.setName("Круг стальной d10");
//        material1.setUnitOfMeasurement("погон. м.");
//        Material material2 = new Material();
//        material2.setArt("Лист г/к 1,5х2500х1250 Ст08");
//        material2.setName("Лист стальной г/к, 1,5х2500х1250");
//        material2.setUnitOfMeasurement("кв. м.");
//        Material material3 = new Material();
//        material3.setArt("Сталь 40Х ГОСТ 4543-71");
//        material3.setName("Круг стальной d80");
//        material3.setUnitOfMeasurement("погон. м.");
//        materialRepository.saveAll(List.of(material1, material2, material3));
//
//        Unit shaft = new Unit();
//        shaft.setArt("ДМ 311-09.10.15");
//        shaft.setName("Вал");
//        shaft.setMaterial(material3);
//        shaft.setConstructor(vasya);
//        shaft.setMaterialAmount(0.4f);
//        shaft.setTechnology(technology);
//
//        Unit drive = new Unit();
//        drive.setArt("ДМ 311-09.30.00 СБ");
//        drive.setName("Приводной вал");
//        drive.setMaterial(null);
//        drive.setConstructor(vasya);
//        drive.setMaterialAmount(null);
//        drive.setTechnology(null);
//        unitRepository.saveAll(List.of(shaft, drive));
//
//        UnitRelation driveAndShaftRelation = new UnitRelation();
//        driveAndShaftRelation.setAsm(drive);
//        driveAndShaftRelation.setPart(shaft);
//        driveAndShaftRelation.setQty(1);
//        unitRelationRepository.save(driveAndShaftRelation);
//
//        Ticket ticket = new Ticket();
//        ticket.setConstructor(vasya);
//        ticket.setTechnologist(petya);
//        ticket.setPlanner(petya);
//        ticket.setTimeStudyEngineer(petya);
//        ticket.setName("Приводной вал мотоцикла");
//        ticket.setDescription("На самом деле для подводной лодки, но это секрет");
//        ticketRepository.save(ticket);
//
//        UnitEntry unitEntry = new UnitEntry();
//        unitEntry.setTicket(ticket);
//        unitEntry.setUnit(drive);
//        unitEntry.setQty(2);
//        unitEntryRepository.save(unitEntry);
//
//        List<String> unitNames = ticketRepository
//                .findAll()
//                .get(0)
//                .getUnitEntryList()
//                .stream()
//                .map(ue -> ue.getUnit().getName())
//                .collect(Collectors.toList());
//        logger.info(unitNames);
//
//    }
//
//}
