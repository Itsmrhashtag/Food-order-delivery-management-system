import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryregisterComponent } from './deliveryregister.component';

describe('DeliveryregisterComponent', () => {
  let component: DeliveryregisterComponent;
  let fixture: ComponentFixture<DeliveryregisterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeliveryregisterComponent]
    });
    fixture = TestBed.createComponent(DeliveryregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
