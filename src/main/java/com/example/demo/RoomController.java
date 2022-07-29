package com.example.demo;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable findAll() {
        return roomRepository.findAll();
    }

    @GetMapping("/roomName/{roomName}")
    public List findByName(@PathVariable String roomName) {
        return roomRepository.findByName(roomName);
    }

    @GetMapping("/{id}")
    public Room findOne(@PathVariable Long id) {
        return roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        roomRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable Long id) {
        if (room.getId() != id) {
            throw new RoomIdMismatchException();
        }
        roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        return roomRepository.save(room);
    }
}
