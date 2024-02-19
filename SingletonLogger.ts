import * as fs from 'fs/promises';

interface LogData {
  timestamp: string;
  level: 'LOG' | 'ERROR' | 'WARNING';
  message: string;

  // async(a: number, b: number): Promise<number>;
  // this for function in interface
}

class Logger {
  private static instance: Logger | null = null;
  private logFilePath: string;

  private constructor(logFilePath: string) {
    this.logFilePath = logFilePath;
    this.initializeLogFile();
  }

  static getInstance(logFilePath: string): Logger {
    if (!Logger.instance) {
      Logger.instance = new Logger(logFilePath);
    }
    return Logger.instance;
  }

  private async initializeLogFile(): Promise<void> {
    try {
      await fs.access(this.logFilePath);
    } catch (err) {
      if (err.code === 'ENOENT') {
        // Log file doesn't exist, create it
        await fs.writeFile(this.logFilePath, '');
      } else {
        console.error('Error accessing log file:', err);
      }
    }
  }

  private async appendToFile(data: LogData): Promise<void> {
    try {
      await fs.appendFile(this.logFilePath, JSON.stringify(data) + '\n' + ',');
    } catch (err) {
      console.error('Error writing to log file:', err);
    }
  }

  private getCurrentTimestamp(): string {
    return new Date().toISOString();
  }

  public log(message: string): void {
    const logData: LogData = {
      timestamp: this.getCurrentTimestamp(),
      level: 'LOG',
      message: message
    };
    this.appendToFile(logData);
    console.log(`[LOG] ${message}`);
  }

  public error(message: string): void {
    const logData: LogData = {
      timestamp: this.getCurrentTimestamp(),
      level: 'ERROR',
      message: message
    };
    this.appendToFile(logData);
    console.error(`[ERROR] ${message}`);
  }

  public warn(message: string): void {
    const logData: LogData = {
      timestamp: this.getCurrentTimestamp(),
      level: 'WARNING',
      message: message
    };
    this.appendToFile(logData);
    console.warn(`[WARNING] ${message}`);
  }
}

// Example usage:
const logger = Logger.getInstance('log.json');

logger.log("This is a log message.");
logger.error("This is an error message.");
logger.warn("This is a warning message.");
