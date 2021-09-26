package Controller;
//интейрфес-маркер, это значит, что он не содержит никаких методов
//и существует для валидации команд в инвокере

//указывает что для команды нужно создание города(типа add, update)
public interface CommandWithObject extends Commandable{

}
